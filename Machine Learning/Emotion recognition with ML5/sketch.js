let mobilenet;
let video;
let classifier;
let predictions = [];
let probabilities = [];
let classButtons = [];
let trainButton;
let trainingProgress;
let canvas;

let cut;
let ctracker;


let classes = ['Happy', 'Sad', 'Surprised'];
let classesCount = [0, 0, 0];

function setup() {
  video = createCapture(VIDEO);
  video.parent('mainCanvas');
  video.size(649, 480);
  video.position(0, 0);
  video.hide();
  canvas = createCanvas(640, 480);
  canvas.parent('mainCanvas');
  background(20);

  // video.hide();
  mobilenet = ml5.featureExtractor('MobileNet', {   
    version: 1,
    alpha: 1.0,
    topk: 3,
    learningRate: 0.0001,
    hiddenUnits: 100,
    epochs: 20,
    numClasses: 3,
    batchSize: 0.4,
  }, () => {
    console.log('Model is ready!');
  });

  mobilenet.numClasses = 3;

  classifier = mobilenet.classification(video, ()=> console.log('Video is ready!'));

  trainingProgress = select('#training-progress');

  for (let i = 0; i < 3; i++) {
    predictions.push(select('#class' + (i - (-1)) + '-name'));
    probabilities.push(select('#class' + (i - (-1)) + '-probability'));
    classButtons.push(select('#class' + (i - (-1)) + 'button'));
    classButtons[i].mousePressed(function () {
      // while(cut.pixels.length == 0);
      // console.log(cut);
      classifier.addImage(classes[i], () =>{ 
        console.log('Added!');
      });
      classButtons[i].html(classes[i] + ' (' + (++classesCount[i]) + ')');
    });
  }
  trainButton = select('#train-button');
  trainButton.mousePressed(function () {
    let progress = 0;
    classifier.train((loss) => {
      if (loss === null) {
        trainingProgress.attribute('style', 'width:100%');
        trainingProgress.html('Finished');
        console.log('Training finished!');
        classifier.classify(gotResults);
      } else {
        progress = lerp(progress, 100, .2);
        trainingProgress.attribute('style', 'width:' + progress + '%');
        // trainingProgress.attribute('style', 'width:'+progress+'%');
        console.log(loss);
      }
    });
  });

  // setup tracker
  // ctracker = new clm.tracker();
  // ctracker.init(pModel);
  // ctracker.start(videoInput.elt);
  // setup tracker
  ctracker = new clm.tracker();
  ctracker.init(pModel);
  ctracker.start(video.elt);

  noStroke();
}

function draw() {
  // image(video, 0, 0, width, height);
  clear();
  // if(videoInput) {
  image(video, 0, 0);
  // }
  // get array of face marker positions [x, y] format
  positions = ctracker.getCurrentPosition();

  let minx = width, miny = height, maxx = 0, maxy = 0;

  for (var i = 0; i < positions.length; i++) {
    if (positions[i][0] > maxx) {
      maxx = positions[i][0];
    }

    if (positions[i][1] > maxy) {
      maxy = positions[i][1];
    }

    if (positions[i][0] < minx) {
      minx = positions[i][0];
    }

    if (positions[i][1] < miny) {
      miny = positions[i][1];
    }
  }  // set the color of the ellipse based on position on screen
  // background(0);
  let cw = maxx - minx, ch = maxy - miny;
  if (cw > 0 && ch > 0) {
    // loadPixels();
    cut = get(minx, miny, cw, ch);
    cut.loadPixels();
    cut.updatePixels();
    noFill();
    stroke(255, 255, 0)
    rect(minx, miny, cw, ch);
    background(0, 0, 0, 100);
    image(cut, minx, miny);

  }
  // for (var i = 0; i < positions.length; i++) {
  //   // set the color of the ellipse based on position on screen
  //   fill(map(positions[i][0], width * 0.33, width * 0.66, 0, 255), map(positions[i][1], height * 0.33, height * 0.66, 0, 255), 255);
  //   // draw ellipse at each position point
  //   var val = 5;
  //   ellipse(positions[i][0], positions[i][1], val);
  // }
}

function gotResults(error, result) {
  if (error) {
    console.log(error);
  } else {
    // console.log(result);
    for (let i = 0; i < 3; i++) {
      predictions[i].html(classes[i]);
      probabilities[i].html((result == classes[i] ? 100 : 0) + '%');
      probabilities[i].attribute('aria-valuenow', (result == classes[i] ? 100 : 0));
      // probabilities[i].attribute('style', 'width:' + floor(results[i].probability * 100)+ '%');
      probabilities[i].attribute('style', 'width:' + (result == classes[i] ? 100 : 0) + '%');
    }
    classifier.classify(gotResults);
  }

}
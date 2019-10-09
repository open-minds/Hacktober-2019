using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace DesktopApp
{
    /// <summary>
    /// Logique d'interaction pour Calculator.xaml
    /// </summary>
    public partial class Calculator : Window
    {
        double firstNum = 0f;
        double secondNum = 0f;
        int operation = -1;
        string operationString;
        bool used;

        public Calculator()
        {
            InitializeComponent();
        }

        private void ButtonClick(object sender, RoutedEventArgs e)
        {
            if (used)
            {
                used = false;
                firstNum = secondNum = 0;
                operation = -1;
                operationString = "";
                textBoxOperation.Text = "Operations will appear here...";
                textBoxSolution.Text = "Solution";
            }

            if (this.textBoxOperation.Text.Equals("Operations will appear here..."))
            {
                this.textBoxOperation.Text = "";
            }
            if (((Button)sender).Content.ToString() == "Del")
            {
                if (this.textBoxOperation.Text.Length > 0)
                    this.textBoxOperation.Text = this.textBoxOperation.Text.Remove(this.textBoxOperation.Text.Length - 1);
            }
            else
            {
                this.textBoxOperation.Text += ((Button)sender).Content;
            }
        }

        private void ButtonOp(object sender, RoutedEventArgs e)
        {
            if (this.textBoxOperation.Text.Equals("Operations will appear here..."))
            {
                MessageBox.Show("You can't start with an operation!");
            }
            else
            {
                String tempOp = ((Button)sender).Content.ToString();
                if (tempOp == "=")
                {
                    CalculateSolution();
                }
                else if (tempOp == "C")
                {
                    used = false;
                    firstNum = secondNum = 0;
                    operation = -1;
                    operationString = "";
                    textBoxOperation.Text = "Operations will appear here...";
                    textBoxSolution.Text = "Solution";
                }
                else
                {
                    operationString = tempOp;

                    if (operationString == "+")
                    {
                        operation = 0;
                    }
                    else if (operationString == "-")
                    {
                        operation = 1;
                    }
                    else if (operationString == "x")
                    {
                        operation = 2;
                    }
                    else if (operationString == "/")
                    {
                        operation = 3;
                    }
                    else if (operationString == "%")
                    {
                        operation = 4;
                    }
                    else
                    {
                        MessageBox.Show("Coming soon...");
                    }
                    firstNum = double.Parse(this.textBoxOperation.Text);
                    this.textBoxOperation.Text += ((Button)sender).Content;
                }
            }
        }

        void CalculateSolution()
        {
            secondNum = double.Parse(this.textBoxOperation.Text.Split(operationString[0])[1]);
            if (secondNum == 0 && operation == 3)
            {
                MessageBox.Show("Error, devision by zero is not tolerated");
            }
            else
            {
                double result;
                switch (operation)
                {
                    case 0:
                        result = firstNum + secondNum;
                        break;
                    case 1:
                        result = firstNum - secondNum;
                        break;
                    case 2:
                        result = firstNum * secondNum;
                        break;
                    case 3:
                        result = firstNum / secondNum;
                        break;
                    case 4:
                        result = firstNum % secondNum;
                        break;
                    default:
                        result = 0;
                        break;
                }
                
                    string[] preAnswers =
                    {
                    "I think it's ",
                    "You ll get ",
                    "Ehhh...",
                    "Well, it's ",
                    "Pfff, it's "
                    };
                    string[] postAnswers =
                    {
                    " Right?",
                    " I'm sure",
                    " I think..",
                    " Or is it?",
                    ""
                    };
                    int randomIndex = new Random().Next(5);
                    this.textBoxSolution.Text = preAnswers[randomIndex] + result + postAnswers[randomIndex];
                    used = true;

                if ((result % 1) == 0)
                {
                    getFunnyFact("http://numbersapi.com/" + result);
                }
            }
        }

        private void funnyFact(object sender, RoutedEventArgs e)
        {
            if (int.TryParse(this.textBoxOperation.Text, out int a))
                getFunnyFact("http://numbersapi.com/" + a);
            else MessageBox.Show("Please enter a valid format (integer)");
        }

        public async Task<string>  getFunnyFact(string url)
        {
            var request = (HttpWebRequest)WebRequest.Create(url);

            request.Method = "GET";
            
            var content = string.Empty;

            var response = await request.GetResponseAsync();
            var stream = response.GetResponseStream();
            var sr = new StreamReader(stream);
            content = sr.ReadToEnd();
               
                        //textBoxSolution.Text = content;
            new FunFact(content).Show();
            return "";
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {

        }
    }
}

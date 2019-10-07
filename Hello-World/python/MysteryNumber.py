import random

def play(username="Alian"):
    exit = False
    score = 0
    mysterNumber = random.randint(1, 100)
    while(not(exit)):
      userInput = input("Enter a number ")
      print("User "+username+" say : "+userInput+"\n")
      if(int(userInput) > mysterNumber):
        print("Bot  : Go down \n")
      elif int(userInput) > mysterNumber:
          print("Bot : Go up \n")
      else:
          print("Bot : Congratulation\n")
          score +=1
          resp  = input("continue Yes or No ?\n")
          if resp == "N":
             exit = True
          else:
              mysterNumber = random.randint(1, 100)  
    print(username+" Score "+score)
    
        
if  __name__ == "__main__":
    print("Welcome Hacktoberfest Mystery Number (:|?|:) \n:")
    username = input("Enter your username")
    print("Figure The mystery number from 1 to 100 GOOD LACK \n")
    play(username)
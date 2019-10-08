import random


def setChance(diffi):
     if diffi == "1":
       chance = 7
     elif diffi == "2":
         chance = 5
     else:
         chance = 3
     return chance


def play(diffi, username="Alian"):
     exit = False
     score = 0
     chance = setChance(diffi)
     mysterNumber = random.randint(1, 100)
     print("\n You have "+chance.__str__()+" chance ")
     while(not(exit) and chance != 0):
       userInput = input("Enter a number ")
       print("\nUser "+username+" say : "+userInput+"\n")
       if(int(userInput) > mysterNumber):
         print("Bot  : Go down \n")
         chance -=1
         print("You left: "+chance.__str__()+" Chance\n")
       elif int(userInput) < mysterNumber:
          print("Bot : Go up \n")
          chance -=1
          print("You have left: "+chance.__str__()+" Chance\n")
       else:
          print("Bot : Congratulation\n")
          if diffi == "1":
             score +=1
          elif diffi == "2":
              score +=10
          else:
              score +=100
          print("Your score is actualy "+score.__str__()+"\n")
          resp  = input("Play Another partie Yes or No ?")
          print("\n")
          if resp == "No":
             exit = True
          else:
              chance = setChance(diffi)
              mysterNumber = random.randint(1, 100)
     print("GAME OVER\n")
     print(""+username+" Final  Score "+score.__str__())


if  __name__ == "__main__":
    print("Welcome Hacktoberfest Mystery Number (:|?|:) \n")
    username = input("Enter your username \n")
    print("Figure The mystery number from 1 to 100 GOOD LACK "+username+" \n")
    print("Choose difficulties \
           1) Easy (SAHLA MAHLA) \
           2) Medium (NRML) \
           3) Hard ( KHATINI NTA RAK BARIHA  HAKA)")
    difficulties = input("Enter N° :")
    play(difficulties, username)
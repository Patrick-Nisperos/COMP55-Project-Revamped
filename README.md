# COMP 55 Resurrection
## Overview of New Feature
At the moment, enemies fire all at once (poor gameplay). 

![image](https://user-images.githubusercontent.com/87968531/150917411-8818f07a-6255-499e-a1c5-ae7e0a21518a.png)
![Project Tanks Game GIF](https://user-images.githubusercontent.com/87968531/151684805-834496aa-7b15-44e2-b917-e611bb96c1e8.gif)


**New feature** - Enable the enemies to fire at different rates. Rates will be determined by reading in files as test cases.
This creates flexibility and makes the program more dynamic for developers.

## Pseduocode
The following is high-level psuedocode that does not cover granular details, instead this covers the overall picture.  
**_Gameplay.java_**  
Modify the following methods: _enemyFire()_  
Add the following methods: _callEnemyFire()_

enemyFire() is called by callEnemyFire()
```
enemyFire(Enemy currentEnemy) {
  if (canEnemyFire(currentEnemy) {
    currentEnemy.fire(currentEnemy.coordinates)
  }
} 
```

input to callCanEnemyFire() is set by the test cases
test cases consist of:  
tankNumber (order in which the enemy tank appears from left to right starting from 0 to x)  
tankInterval (corresponding time intervals that it takes for that enemy tank to fire)
callEnemyFire is called by game timer
```
callEnemyFire(int tankNumbers[], int tankIntervals[]) {
  for (int i = 0; i < tankNumbers.size; i++) {
    if (currentTime % tankIntervals[i] == 0) {
      enemyFire(enemies[tankNumber[i])
    }
  }

}
```
sampleTestCase.txt  
where the first number is the tank number, and the second is the time interval in seconds
```
1 2
2 3.5
3 2
4 1.5
5 3.5
```
## Finshed Feature Demonstration
The new feature has been implemented as of 1/29/2022. Below is a demonstration of the feature. Programmers may also choose to test it out themselves by following these steps:
1) Edit enemyFireRates.txt to parameters in each line (tankNumber, tankInterval (in milliseconds))  
2) Run gamePlay.java  

### Test Case # 1
enemyFireRates.txt - These intervals are short to differentiate between test case #1 and test case #2
![First Test Case](https://user-images.githubusercontent.com/87968531/151684814-6d5d0dc7-2e9a-40eb-8444-e2fdafe73d12.PNG)

Enemies firing at the rates specified in enemyFireRates.txt
![First Test Case](https://user-images.githubusercontent.com/87968531/151685093-3b291ef3-f1ed-4c7d-90e7-35073e4c2ace.gif)


### Test Case # 2
enemyFireRates.txt - These intervals are long to differentiate between test case #1 and test case #2
![Second Test Case](https://user-images.githubusercontent.com/87968531/151684851-8972988a-e3a2-4b75-9339-e49b484c47be.PNG)

Enemies firing at the rates specified in enemyFireRates.txt
![Second Test Case](https://user-images.githubusercontent.com/87968531/151685096-e5a16306-027d-4f4d-9c38-d810093bcdd1.gif)






# COMP 55 Resurrection
## Overview of New Feature
At the moment, enemies fire all at once (poor gameplay). 

![image](https://user-images.githubusercontent.com/87968531/150917411-8818f07a-6255-499e-a1c5-ae7e0a21518a.png)

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

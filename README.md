# 🎰 LOOT-TABLE 🎰

[![Java CI with Gradle](https://github.com/bfresnel/loot-table-poc/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/bfresnel/loot-table-poc/actions/workflows/gradle.yml)
[![CodeQL](https://github.com/bfresnel/loot-table-poc/actions/workflows/codeql-analysis.yml/badge.svg?branch=main)](https://github.com/bfresnel/loot-table-poc/actions/workflows/codeql-analysis.yml)

## Description

This project was created in order to understand how all looting games are working.
This project could also be updated or not.

**_It has many flaws, like no-real logging, no database etc etc... it's just a personal project._**

## Principle

We have 2 files that contains data :

* ```characters.json``` : Contains all characters and their rarity
* ```drop-chance.json``` : Contains all percentage for each rarity

⚠️ _**These files can be edited. However, there is absolutely no percentage control for the ```drop-chance.json```
file.**_

For each pull, we retrieve 5 lists of 10 characters.
In each list -> we integrate as much character as their rarity in a 100-sized array.

For example :

- For a character with a 50% drop chance, we add 50 characters in this array.
- For a character with a 25% drop chance, we add 25 characters in this array
- etc etc ...

After creating this array, we randomly select 10 characters and this is our result !

If you liked this, don't forget to add a 🌟 👋

## How to use it

You have to install the java JDK with version >= 16.0.2

Go to the folder where the downloaded jar is located then use the following command :

```
$ java -jar loot-table-1.0.0.jar
```

# 🎰 LOOT-TABLE 🎰

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bfresnel_loot-table-poc&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=bfresnel_loot-table-poc)
[![Java CI with Gradle](https://github.com/bfresnel/loot-table-poc/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/bfresnel/loot-table-poc/actions/workflows/gradle.yml)
[![CodeQL](https://github.com/bfresnel/loot-table-poc/actions/workflows/codeql-analysis.yml/badge.svg?branch=main)](https://github.com/bfresnel/loot-table-poc/actions/workflows/codeql-analysis.yml)

## Description

This project was created in order to understand how all looting games are working.
This project could also be updated or not.

**_It has many flaws, it's just a personal project._**

## Principle

For each pull, we retrieve a list of 10 characters.
In each list -> we integrate as much character as their rarity in a 100-sized array.

For example :

- For a character with a 50% drop chance, we add 50 characters in this array.
- For a character with a 25% drop chance, we add 25 characters in this array
- etc etc ...

After creating this array, we randomly select 10 characters and this is our result !

If you liked this, don't forget to add a 🌟 👋

## How to use it

    $ cd loot-table
    $ docker-compose up -d .

The last command will build everything under docker including the webapp and the database (it includes a Postgresql
image)

# Advent of code 2021 - Day 5 puzzle - Hydrothermal Venture

## To run

Example

$ node src/public/day05HydrothermalVents.js src/public/day05exampHydrothermalVentsData.txt

Puzzle

$ node src/public/day05HydrothermalVents.js src/public/day05HydrothermalVentsData.txt

## To test

Uses Jest for testing

$ npm run test

## Tech stack

Node.js + React template

## User story

As a submarine pilot
I want to find how many points in a field of hydrothermal vents with at least two lines overlap
So I can avoid the most dangrous areas in the field


## Acceptance criteria

1. The user should be able to input a list of nearby liens of vents
2. only consider horizontal and vertical lines: lines where either x1 = x2 or y1 = y2
3. Show the how many points at least two lines overlap

## day 5 puzzle - Hydrothermal Venture

Puzzle description https://adventofcode.com/2021/day/5 

The number of points where at least two lines overlap is  6856
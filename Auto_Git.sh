#!/bin/sh

git add *

date_time=$(date)

git commit -m "auto git push  Java eclipse project: ${date_time}"

git push origin master


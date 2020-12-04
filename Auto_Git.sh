#!/bin/sh

git add *

date_time=$(date)

#git commit -m "auto git push  Java eclipse_Project: ${date_time}"
git commit -m "GSON练习：完成B站视频和音频文件合并: ${date_time}"

git push origin master


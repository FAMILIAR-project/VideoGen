#!/bin/bash

# initialize counter
countFile=0
i=0


# directory passed in parameter
PASSED=$1

#output file
output=$2

echo "videoGen" > $2

# go through the directory listing
for folder in $PASSED/*; do
 
    i=$((i+1))
    #echo "$name"  --> play/v1
     
    #count files number in this directory
    countFile=$(ls $folder | wc -l)
    echo $countFile

    #testing files  number
    if [ $countFile = 1 ]; then
       
       #obligatory video
       
       echo "mandatory videoseq v: "$i" /"$folder"/"$(ls $folder) >> $2
      

    else
       #alternative videos
       echo "alternative videos v"$i" {" >> $2
       j=0
       for filename in $folder/*; do
              j=$((j+1))
  	      echo "v"$i$j" : /"$filename >> $2
       done;
       echo "}" >> $2
    fi

done




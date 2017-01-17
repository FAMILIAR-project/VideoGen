#!/bin/bash

cd v 
for var in ls
do 
if [ -d $var]; then
 count=`ls $var | wc -l `
  
   if [ $count -gt 1 ]; then 
     echo "mandatory"

    else 
      echo "alternatives"

   fi 
  fi 
done
 



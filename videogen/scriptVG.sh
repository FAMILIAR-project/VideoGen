#!/bin/bash
echo `pwd`

integer1=1
cd v
#ecriture
echo "VideoGen {" > creationAutomatique.videogen
for D in `find . -type d`
do
	if [ $D == "." ]; then
		echo "Les différents path avec ./ au début, dsl"
	else
		#echo 1`pwd`   $D
		cd $D
		if [ `find . -type f -exec ls {} \; | grep -v .png | wc -l` -gt 1 ]; then
			#alternative
			echo alternative `find . -type f -exec ls {} \; | grep -v .png`
			#ecriture
			echo -e "\talternatives v"$integer1" {" >> ../creationAutomatique.videogen
			integer2=0
			for f in `find . -type f | grep -v .png`
			do
				#ecriture
				echo -e "\t\tvideoseq v"$integer1$integer2 \"$f\" >> ../creationAutomatique.videogen
				integer2=$[integer2+1]
			done
			#ecriture
			echo -e "\t}" >> ../creationAutomatique.videogen
		else
			#mandatory
			echo mandatory `find . -type f -exec ls {} \; | grep -v .png`
			#ecriture
			echo -e "\tmandatory videoseq v"$integer1 \"`find . -type f -exec ls {} \; | grep -v .png`\" >> ../creationAutomatique.videogen
		fi
		cd ..

		integer1=$[integer1+1]

fi
done
#ecriture
echo "}" >> creationAutomatique.videogen


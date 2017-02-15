cnt=0
while read line && [ $cnt -le 10 ]; 
do
	cnt=`expr $cnt + 1`
	if [ $cnt -eq 10 ]; then
	echo $line
	exit 0
	fi
done < ../test.txt

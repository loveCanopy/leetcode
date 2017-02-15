awk 'NR==10' test.txt
awk 'FNR==10 {print $0}' test.txt
awk 'FNR==10 {print}' test.txt
sed -n 10p test.txt
tail -n+10 test.txt|head -1

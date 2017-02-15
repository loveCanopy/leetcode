sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' telephone.txt
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' telephone.txt 

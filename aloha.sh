#!/bin/bash

checkNotNull() {
	if [ -z "$1" ]; then
    echo "ERR : Can't be empty"
    exit 1
	fi
}

set_environment_variable() {
	export Alohomora_DB_URL=$dbURL
	export Alohomora_DB_username=$username
	export Alohomora_DB_password=$password
}

echo "######################"
echo  Welcome to Alohomora
echo "######################"
echo "\n\nEnter Database Connection URL"
read dbURL
checkNotNull $dbURL
echo "\nEnter Username to connect to Database"
read username
echo "\nEnter Password to connect to Database"
read -s password

set_environment_variable
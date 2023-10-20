#!/bin/bash
# Check if enough arguments are provided
if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <db_username> <db_password> <db_name>"
    exit 1
fi

# Get the arguments
DB_USERNAME="$1"
DB_PASSWORD="$2"
DB_NAME="$3"
# Switch to the postgres user and execute the psql commands
sudo  psql -c "CREATE ROLE $DB_USERNAME WITH LOGIN PASSWORD '$DB_PASSWORD';"
sudo  psql -c "ALTER ROLE $DB_USERNAME CREATEDB;"

# Create a new database with the new user as owner
sudo  psql -c "CREATE DATABASE $DB_NAME WITH OWNER = $DB_USERNAME;"

# Execute the .sql file
sudo  psql -U $DB_USERNAME -d $DB_NAME -a -f init.sql

echo "User $DB_USERNAME created with CREATEDB privilege."
echo "Database $DB_NAME created and init.sql executed."
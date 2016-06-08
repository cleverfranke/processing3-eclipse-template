#!/bin/bash

# Validate user input
if [ $# -eq 0 ]
  then
    echo "No arguments supplied, expecting project name"
    exit 1
fi

PROJECT_PATH=$( cd "$(dirname "${BASH_SOURCE}")" ; pwd -P )

# Replace project name
sed -i 's/Processing3EclipseTemplate/'$1'/g' $PROJECT_PATH/.project

# Reinitialize git
echo "Reinitializing Git"
rm -Rf .git
git init
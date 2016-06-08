#!/bin/bash

# Validate user input
if [ $# -eq 0 ]
  then
    echo "No arguments supplied, expecting project name"
    exit 1
fi

# Replace project name
sed -i 's/Processing3EclipseTemplate/'$1'/g' .project

# Reinitialize git
echo "Reinitializing Git"
rm -Rf .git
#!/bin/bash

# Validate user input
if [ $# != 2 ]
  then
    echo "Arguments missing, require project "
    exit 1
fi

get_abs_filename() {
  # $1 : relative filename
  if [ -d "$(dirname "$1")" ]; then
    echo "$(cd "$(dirname "$1")" && pwd)/$(basename "$1")"
  fi
}

# Define vars
SOURCE_ARCHIVE=https://github.com/cleverfranke/processing3-eclipse-template/archive/master.zip
TMP_DIR=/tmp/processing-template-master
TMP_ARCHIVE=$TMP_DIR.zip
TARGET_DIR=$(get_abs_filename $2)
PROJECT_NAME=$1

# Download template archive to tmp and unpack to target dir
echo "> Downloading and extracting template..."
wget -q -O $TMP_ARCHIVE $SOURCE_ARCHIVE
unzip -q $TMP_ARCHIVE -d $TMP_DIR
mv $TMP_DIR/* $TARGET_DIR

# Replace project name in Eclipse project file
sed -i 's/Processing3EclipseTemplate/'$PROJECT_NAME'/g' $TARGET_DIR/.project

# Initialize git
echo "> Initializing Git..."
git init $TARGET_DIR

# Cleanup
echo "> Cleaning up..."
rm $TMP_ARCHIVE
rm $TARGET_DIR/readme.md
rm $TARGET_DIR/setup.sh
rm -- $0

echo "Done, to start using this template, in the Eclipse project explorer choose 'File' > 'Import' > 'Existing projects into Workspace' and then select '$TARGET_DIR'"

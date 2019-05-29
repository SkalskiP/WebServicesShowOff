#!/bin/bash

##################################################################################################################
# Author 	: 	Piotr Skalski
# Website 	: 	https://github.com/SkalskiP
##################################################################################################################

brew install python3
pip3 install virtualenv
virtualenv -p python3 .env       # Create a virtual environment
source .env/bin/activate         # Activate the virtual environment
pip install -r requirements.txt  # Install dependencies
deactivate
echo "**************************************************"
echo "*****         End of Python Setup         ********"
echo "**************************************************"
echo ""
echo "If you had no errors, You can proceed to work with your virtualenv as normal."
echo "(run 'source .env/bin/activate' in your assignment directory to load the venv,"
echo " and run 'deactivate' to exit the venv. See assignment handout for details.)"

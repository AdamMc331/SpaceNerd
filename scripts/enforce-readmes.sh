#!/bin/bash

# This script enforces that every module in the project has a README.md file.

# Function to check for README.md in a given module
check_readme() {
  module_path=$1
  if [ ! -f "$module_path/README.md" ]; then
    echo "Error: Module '$module_path' is missing a README.md file."
    exit 1
  fi
}

# Read all modules from settings.gradle.kts
# This command extracts the module paths from the include() statements
modules=$(grep -o "include(\":.*\")" settings.gradle.kts | sed 's/include(":\(.*\)")/\1/' | tr ':' '/')

# Check each module
for module in $modules; do
  check_readme "$module"
done

echo "All modules have a README.md file."
exit 0

#!/bin/bash

# This script enforces that every module in the project has a README.md file.

missing_readmes=()

# Function to check for README.md in a given module
check_readme() {
  module_path=$1
  if [ ! -f "$module_path/README.md" ]; then
    missing_readmes+=("$module_path")
  fi
}

# Read all modules from settings.gradle.kts
# This command extracts the module paths from the include() statements
modules=$(grep -o "include(\":.*\")" settings.gradle.kts | sed 's/include(":\(.*\)")/\1/' | tr ':' '/')

# Check each module
for module in $modules; do
  check_readme "$module"
done

if [ ${#missing_readmes[@]} -ne 0 ]; then
  echo "Error: The following modules are missing a README.md file:"
  for module in "${missing_readmes[@]}"; do
    echo "  - $module"
  done
  exit 1
else
  echo "All modules have a README.md file."
  exit 0
fi

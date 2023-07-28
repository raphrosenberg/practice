#!/usr/bin/python
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google's Python Class
# http://code.google.com/edu/languages/google-python-class/

import sys
import re
import os
import shutil
import subprocess

"""Copy Special exercise
"""

# +++your code here+++
# Write functions and modify main() to call them
def get_special_paths(dir):
  dir_list = os.listdir(dir)
  pattern = r'.*__\w+__.*'
  paths = []
  for file in dir_list:
    if re.search(pattern, file): paths.append(file)
  return paths

def copy_to(paths, dir):
  if not os.path.isdir(dir):
    os.makedirs(dir, mode=511, exist_ok=False)
  for file in paths: 
    if not os.path.isdir(file):
      shutil.copy(file, dir)

def zip_to(paths, zippath):
  paths_tostring = ' '.join(paths)
  cmd = f'zip -j {zippath} {paths_tostring}'
  print(f'Zip command: {cmd}')
  (status, output) = subprocess.getstatusoutput(cmd)
  if status:
    sys.stderr.write(output)
    print()
    sys.exit(status)
  print(output)

def main():
  # This basic command line argument parsing code is provided.
  # Add code to call your functions below.

  # Make a list of command line arguments, omitting the [0] element
  # which is the script itself.
  args = sys.argv[1:]
  if not args:
    print ("usage: [--todir dir][--tozip zipfile] dir [dir ...]")
    sys.exit(1)

  # todir and tozip are either set from command line
  # or left as the empty string.
  # The args array is left just containing the dirs.
  todir = ''
  if args[0] == '--todir':
    try:
      todir = args[1]
      del args[0:2]
    except IndexError:
      print('error: missing todir directory')
      sys.exit(1)

  tozip = ''
  if args[0] == '--tozip':
    try:
      tozip = args[1]
      del args[0:2]
    except IndexError:
      print('error: missing tozip directory')
      sys.exit(1)

  if len(args) == 0:
    print ("error: must specify one or more dirs")
    sys.exit(1)

  directory = args[0]
  del args[0]

  # +++your code here+++
  # Call your functions
  if todir:
    copy_to(get_special_paths(directory), todir)
  elif tozip:
    zip_to(get_special_paths(directory), tozip)
  else:
    for dir_entry in get_special_paths(directory): print (dir_entry)

if __name__ == "__main__":
  main()

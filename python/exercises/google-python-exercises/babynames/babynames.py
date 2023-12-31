#!/usr/bin/python
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google's Python Class
# http://code.google.com/edu/languages/google-python-class/

import sys
import re

"""Baby Names exercise

Define the extract_names() function below and change main()
to call it.

For writing regex, it's nice to include a copy of the target
text for inspiration.

Here's what the html looks like in the baby.html files:
...
<h3 align="center">Popularity in 1990</h3>
....
<tr align="right"><td>1</td><td>Michael</td><td>Jessica</td>
<tr align="right"><td>2</td><td>Christopher</td><td>Ashley</td>
<tr align="right"><td>3</td><td>Matthew</td><td>Brittany</td>
...

Suggested milestones for incremental development:
 -Extract the year and print it
 -Extract the names and rank numbers and just print them
 -Get the names data into a dict and print it
 -Build the [year, 'name rank', ... ] list and print it
 -Fix main() to use the extract_names list
"""

def extract_names(filename):
  """
  Given a file name for baby.html, returns a list starting with the year string
  followed by the name-rank strings in alphabetical order.
  ['2006', 'Aaliyah 91', Aaron 57', 'Abagail 895', ' ...]
  """
  # +++your code here+++
  year_regex = r'<h3.*?>.*(\d\d\d\d)'
  name_regex = r'<tr.*><td>(\d+)</td><td>(\w+)</td><td>(\w+)'
  with open(filename) as f:
    list = []
    for line in f:
      #print('line is ', line)
      year_match = re.search(year_regex, line)
      name_match = re.search(name_regex, line)
      re.
      if year_match and not list:
        list.append(year_match.group(1))
      elif name_match:
        male_name = name_match.group(2) + ' ' + name_match.group(1)
        female_name = name_match.group(3) + ' ' + name_match.group(1)
        list.append(male_name) 
        list.append(female_name)
  return sorted(list)


def main():
  # This command-line parsing code is provided.
  # Make a list of command line arguments, omitting the [0] element
  # which is the script itself.
  args = sys.argv[1:]

  if not args:
    print ('usage: [--summaryfile] file [file ...]')
    sys.exit(1)

  # Notice the summary flag and remove it from args if it is present.
  summary = False
  if args[0] == '--summaryfile':
    summary = True
    del args[0]

  # +++your code here+++
  # For each filename, get the names, then either print the text output
  # or write it to a summary file
  for filename in args:
    names_list = extract_names(filename)
    if summary:
      outfile_name = names_list[0] + '-output.txt'
      f = open(outfile_name, 'w')
      print(str(names_list), file=f)
    else:
      print(names_list)
  
if __name__ == '__main__':
  main()

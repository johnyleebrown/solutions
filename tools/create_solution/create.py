#!/usr/bin/python
# -*- coding: utf-8 -*-

import os
import re
import sys


# NOTICE
## use quotation marks when there are apostrophes in the title

ppath='/Users/greg/Documents/'

def read_from_file(file_path):
    file = open(file_path, 'r', encoding='utf-8')
    params = file.read()
    file.close()
    return params


def write_to_file(name, new_data):
    f = open(name, "w+")
    f.write(new_data)
    f.close()


def add_package_info_if_needed(path, new_data):
    eliminate_path_for_pckg = ppath+'projects/algorithmic-problems/problems/algorithms/src'
    package_folders = path[len(eliminate_path_for_pckg):].split('/')
    if len(package_folders) > 1:
        package_info = 'package ' + '.'.join(package_folders)[1:] + ';\n\n'
        new_data = package_info + new_data
    return new_data


def create_class_name():
    regex = re.compile('[^a-zA-Z0-9]')
    name = ''
    for arg in sys.argv[1:]:
        if (arg=='-t'):
            continue
        args = arg.split("-")
        for a in args:
            a = regex.sub('', a)
            name += a[:1].upper() + a[1:]
    if name == '':
        raise ValueError('ERROR. No args.')
    return name


def insert_class_name(template, new_file_name):
    return template.replace('$INSERT_CLASS_NAME', new_file_name)


def get_template(new_file_name):
    path = ppath+'projects/algorithmic-problems/tools/create_solution/'
    p = path+'template'
    if sys.argv[-1] == '-t':
        p+='_t'
    return insert_class_name(read_from_file(p), new_file_name)


if __name__ == "__main__":
    class_name = create_class_name()
    new_file_data = get_template(class_name)
    path = os.getcwd()
    new_file_data = add_package_info_if_needed(path, new_file_data)
    write_to_file(path + '/' + class_name + '.java', new_file_data)

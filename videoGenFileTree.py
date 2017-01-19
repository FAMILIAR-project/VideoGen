
from os import listdir
import sys

def listFiles(path):
    files = listdir(path)

    gen = ""

    for file in files:
        videos = listdir(file)
        if videos.len == 1:
            gen += "mandatory videoseq " + file + ' "' + videos[0] + '"\n'
        else:
            gen += "alternatives " + file + " {\n"

            for i in range(videos.len):
                gen += "videoseq " + file + (i+1) + ' "' + videos[i] + '"\n'

            gen += "}\n"

if __name__ == "__main__":

    path = sys.argv[1]

    gen = "VideoGen {\n"

    gen += listFiles(path)

    gen += "}"

    print(gen)
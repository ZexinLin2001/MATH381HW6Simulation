import numpy as np

for i in range(6):
    print("&S" + str(i + 1), end="")
print("\\\\\n\\hline")
for i in range(1, 7):
    print("S" + str(i) + "&", end="")
    for j in range(1, 7):
        arr = np.loadtxt("data/double-s" + str(i) + "s" + str(j) + ".csv", delimiter=",", dtype='int16')
        print("{:.4f}".format(1-np.mean(arr)), end="&")
    print("\b\\\\")

print("\n\n\n")

for i in range(6):
    print("&S" + str(i + 1), end="")
print("\\\\\n\\hline")
for i in range(1, 7):
    print("S" + str(i) + "&", end="")
    for j in range(1, 7):
        arr = np.loadtxt("data/double-s" + str(i) + "s" + str(j) + ".csv", delimiter=",", dtype='int16')
        means = []
        for k in range(10):
            means.append(1-np.mean(arr[1000000*k: 1000000*k + 1000000]))
        print("(" + "{:.4f}".format(min(means)) + ", " + "{:.4f}".format(max(means)) + ")", end="&")
    print("\b\\\\")

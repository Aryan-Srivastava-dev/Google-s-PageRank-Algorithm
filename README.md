# Google-s-PageRank-Algorithm
This project provides a Java implementation of the PageRank algorithm using the iterative power method. PageRank is used to measure the importance of web pages based on the number and quality of incoming links.

The algorithm begins with a transition matrix P, which represents how likely a user is to move from one page to another. Each column shows the outgoing links from a page, and each entry P[i][j] gives the probability of jumping from page j to page i.

To start the computation, the program assigns each page an equal initial rank of 1/n, where n is the total number of pages. It then repeatedly updates the rank vector using the damping factor d = 0.85, which models random jumps to avoid problems like sink nodes. Each iteration applies the PageRank formula, normalizes the results, and checks whether the values have converged.

The iterative process continues until either convergence is detected (difference less than 1e-10) or the maximum limit of 1000 iterations is reached. After completion, the program prints the number of iterations needed, the PageRank values of all pages, and the total probability, which should be very close to 1.

It serves as a clean and minimal reference for understanding how the iterative PageRank method works in practice.

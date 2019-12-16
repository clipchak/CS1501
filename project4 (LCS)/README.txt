Longest Common Subsequence
Colton Lipchak
December 2018


INTRODUCTION

This program finds the Longest Common Subsequence of two strings.  We
know that if s1 and s2 are strings, and c1 and c2 are characters, then
LCS(s1+c1,s2+c2) is:

     LCS(s1,s2)+c1 if c1==c2
     LCS(s1+c1,s2) if c1!=c2 and LCS(s1+c1,s2) > LCS(s1,s2+c2)
     LCS(s1,s2+c2) if c1!=c2 and LCS(s1,s2+c2) > LCS(s1+c1,s2)

Of course, LCS(s1,empty)=LCS(empty,s2)=empty.


INSTALLATION

The following files should be present:

     LCS.java
     TestLCS.java


USAGE

Compile and run :

     javac TestLCS.java
     java TestLCS

The file TestLCS.java has one example.


PROBLEMS

No known problems.
# Presentation about implicit induction

[![Binder](https://mybinder.org/badge_logo.svg)](https://mybinder.org/v2/gh/Algiras/PresentationAboutImplicits/master?urlpath=lab%2Ftree%2Fnotebooks%2Findex.ipynb) [![nbviewer](https://img.shields.io/badge/view%20on-nbviewer-brightgreen.svg)](https://nbviewer.jupyter.org/github/Algiras/PresentationAboutImplicits/tree/master/notebooks/index.ipynb)

This is a repository with sample code for Fp Meetup in Vilnius Lithuania.

In the talk I will discuss methods of scrapping your boilerplate
by using implicit induction and scala's type system. As part of the demo, 
I will talk about `HList` and problems it helps us solve.  

## Definitions

- `Induction` - The inference of a general law from particular instances (Logic)
  - The production of facts to prove a general statement
  - A means of proving a theorem by showing that if it is true of any particular case 
    it is true of the next case in a series, and then showing that it is indeed true in 
    one particular case.

The reading order is:

1. [Basics](src/main/scala/Presentation/Basics.sc) - examples of induction in programming
2. [Tuple](src/main/scala/Presentation/Tuple.sc) - examples of induction using simple data structures
3. [Shape](src/main/scala/Presentation/Shape.sc) - using Shapeless to level up the implementation

## References

- [Using Recursive Typeclasses to Model your Data by Thurston Sandberg](https://www.youtube.com/watch?v=auaT2Ft65Qo)
- [Mastering Typeclass Induction-Aaron Levin](https://www.youtube.com/watch?v=Nm4OIhjjA2o)
- [Shapeless](https://github.com/milessabin/shapeless)

## Metadata

- `Author`: Algimantas Krasauskas
- `Topic`: Implicit Induction using Scala
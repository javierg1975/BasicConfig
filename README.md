#Default KTP Apps sbt configuration
Requires Scala 2.11.0 or higher.

**Fork this template when starting a new project.**

Usage of this template is **mandatory** for all new Scala-based KTP Apps projects.
For existing projects, please consider slowly introducing these configuration options as time and resources allow.

##TL;DR
More stringent compilation options for `scalac`. Adds [WartRemover](https://github.com/puffnfresh/wartremover) and [Scalastyle](http://www.scalastyle.org/) plugins to *sbt*

##What it provides
- Static code analysis.
- Automatic code reviews based on best practices.
- Automatic enforcement of standard coding style.
- A [more capable](https://github.com/paulp/sbt-extras) `sbt` runner
- Peace of mind.

##How to use
- scalac options
    - These will kick in by default when you compile. Nothing to do.
- [WartRemover](https://github.com/puffnfresh/wartremover)
    - Will kick in by default when building with _sbt_.
    - Do check out the [documentation](https://github.com/puffnfresh/wartremover) for more options. Different projects might have slightly different needs.
- [Scalastyle](http://www.scalastyle.org/)
    - Run `sbt scalastyle`
    - Scalastyle allows the use of [rule suppression comments](http://stackoverflow.com/questions/21931431/how-can-i-suppress-scalastyle-warning). Learn how and when to use them
    - **DO NOT** follow advice blindly. Always try to understand the reasons behind a rule. Following advice blindly leads to fear. Fear leads to anger. Anger leads to hate. Hate leads to suffering (you get the point.)

##What it means for you
- Some of the code that previously compiled now won't. This is because the compiler will be looking for things that while legal, might introduce errors in the future.
- You will get errors regarding code structure and best practices. This is no different from the comments you might get from a human reviewer, with the advantage that you'll be notified before doing a pull request.
- Code across all of KTP Apps projects will be subjected to the same coding standards, so jumping to a different project will feel more natural.
- You'll spend a little more time fixing errors during development and a lot less time discovering those errors after deployment.
- I'll be happier. You want me to be happier.

##What it means for me
- I will still review your code, but I'll be happier (I really can't stress that enough.)
- I finally get to talk about Anamorphisms and Monad Transformers.

##What this is not
This is not meant to replace Unit Testing or QA. We still need those.

##If you want to know more
Check out [Leif Wickland's presentation](http://confreaks.com/videos/4863-PNWS2014-towards-a-safer-scala) at PNWScala

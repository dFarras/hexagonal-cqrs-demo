# TABLE OF CONTENTS

1. [Goal](#goal)
    1. [Why multi module?](#why-multi-module)
2. [Patterns covered](#patterns-covered)
3. [Layers](#layers)
4. [Sources](#sources)

# SUMMARY

This projects aims to demonstrate what hexagonal and CQRS architectures would look like in a project.

The whole project is oversimplified in order to help understand those architecture and to help focus on what is actually
important on those designs. It covers two use cases:

1. Create a transfer
2. Find a transfer by reference

## Why multi module?

The project covers simplified use cases for a fake bank to demonstrate how a maven multi-module implementation of what
hexagonal architecture and CQRS would look like.
Bear in mind that for such simple use cases multi-module is an overkill, but it helps to explain different 
responsibilities for the different patterns covered.

# Patterns covered

| pattern                    | short descriptions                                             | benefit                                                                                                 |
|----------------------------|----------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| **hexagonal architecture** | decoupling your business logic from data in or out your system | you can add other channels apart of REST or storage solutions without mutating your business logic      |
| **CQRS**                   | decouple your read from your write operations                  | you can escalate just read operations, they tend to be used more than write ones and also a lot simpler |

# LAYERS

ADD IMAGE

In every hexagonal project there are two important layers, those are the ones that deal with data entering the system
and those who handle data exiting. The idea is that your business logic should not be aware of where the data it is
processing came from, or where the results of that processing are being stored.

Decoupling at this level will, for instance, allow us to create modules in the layer "data in" supporting other channels
like a command line interface without modifying our business logic.
This is good for obvious reasons, but formally we could also defend it as an implementation that follows both the
_"single responsibility principle"_ and _"open close"_ **SOLID principles**.

| block                       | modules                                                            | responsibility                                                          |
|-----------------------------|--------------------------------------------------------------------|-------------------------------------------------------------------------|
| data in                     | <ul> <li>http-channel</li> </ul>                                   | convert raw data (http requests)                                        |
| business logic              | <ul> <li>transfer</li> </ul>                                       | implements business required use cases                                  |
| top level storage behaviour | <ul> <li>reader-connector</li><li>persistence-connector</li> </ul> | handles system behaviour over the different possible storage solutions  |
| data out                    | <ul> <li>cache</li><li>database</li></ul>                          | connects to different storages and sends business logic results to them |

# SOURCES

- Hexagonal architecture: https://alistair.cockburn.us/hexagonal-architecture/
- CQRS: https://martinfowler.com/bliki/CQRS.html
- SOLID: https://en.wikipedia.org/wiki/SOLID
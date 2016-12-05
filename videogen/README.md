# VideoGenerator
See more on https://github.com/acherm/teaching-MDE1617

# Feature Model - Question 14
fmGen = FM (VideoGenerator: Mode; Mode: (Random|Probability|Configurator); Configurator: (WithRandom|WithProbability); ) 

VideoGenerator has got a mandatory mode. This mode will be Random, Probability or Configurator.
The Configurator mode has 2 feature, WithRandom and WithProbability.

# Deployment with Feature Model - Question 15
Create a Jhipster script with have the configuration in parameters.
Depending on the type of configuration, the Jhipster command start :
	For the Random Mode : a website with a generator button.
	For the Probability Mode : a website with a generator button who generate playlist depending on the probability.
	For the Configurator Mode : a website with a drop-down list to choose the random or the probability mode.
 

# DenseOres by RWTema

**Note: Dense Ores has updated to 1.8. If you are looking for the 1.7 code select the 1.7 from the branch list**

## Fork Information

This is a fork of the original DenseOres by RWTema which can be found [here](https://github.com/rwtema/DenseOres).

Releases for this fork can be found [here](https://github.com/TehNut/DenseOres/releases).

## License

[![License](http://i.creativecommons.org/l/by/4.0/88x31)](http://creativecommons.org/licenses/by/4.0/deed.en_GB)

This work is licensed under a [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/deed.en_GB").

Code is provided without guarantee of being error-free or optimal.

## Downloads

**These downloads are all for the original version. Downloads for this fork can be found [here](https://github.com/TehNut/DenseOres/releases)**

**Download of the latest release:** 

[Version 1.4.2](http://www.mediafire.com/download/pkav85stbss1roa/denseores-1.4.2.jar)

**Older Versions:**

[Dense Ores 1.4.1](http://www.mediafire.com/download/leudza3jpd8uvd8/denseores-1.4.1.jar)

[Dense Ores 1.4](http://www.mediafire.com/download/ac7a4hb8cuzm6rb/denseores-1.4.jar)

[Dense Ores 1.3](http://www.mediafire.com/download/vcluluqcd8k0atp/denseores-1.3.jar)

There was no 1.2 version for some reason. 

[Dense Ores 1.1](http://www.mediafire.com/download/7okkg0vqm2zm5z2/denseores-1.1.jar)

[Dense Ores 1.1.0](http://www.mediafire.com/download/5lh66z373w40bx7/denseores-1.0.0.jar)

## Configs

If you wish to add another mods ores to the game, you will need to alter the config file. I generally wouldn't recommend doing this if you are a casual player since this can cause issues. It's best to see if there is a modpack that does it properly for you. There is a simple denseores.cfg that includes a number of ores from some common mods [here](https://github.com/rwtema/DenseOres/blob/master/example_configs/denseores.cfg)

You can also find individual example configs for common mods [here](https://github.com/rwtema/DenseOres/tree/master/example_configs/mods). This will require you to change the ore ids when you add them to your config file. If anyone wishes to add more example configs for common mods, then please feel free to submit a pull request for it.


### Config Info

`S:baseBlock` - The ore block that you wish to replace. This is in the form modid:blockname

`I:baseBlockMeta` - The metadata value for the block (0-15)

`S:baseBlockTexture` - The ores texture name (as found in assets/modid/textures/blocks)

`D:denseOreProbability` - Currently unused.

`I:renderType` - This changes the way the texture generation works (see [here](https://i.imgur.com/CGfhSss.png) for details).

`I:retroGenId` - Retrogen number. Set it to non-zero to enable retrogen. You can change it to a diffent number to run retrogen again.

`S:underlyingBlock` - The texture of the base block (usually stone or netherrack), see baseBlockTexture.

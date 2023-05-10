package com.zuhal.discovergames.data.fake

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.zuhal.discovergames.data.fake.models.Game

val mapper = jacksonObjectMapper()

object FakeGameDataSource {
    val listGame: List<Game>
        get() {
            return mapper.readValue(jsonString, object : TypeReference<ArrayList<Game>>() {})
        }
}

// api response from https://rawg.io/
const val jsonString = """
[
  {
    "id": 3498,
    "slug": "grand-theft-auto-v",
    "name": "Grand Theft Auto V",
    "released": "2013-09-17",
    "background_image": "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
    "description": "Rockstar Games went bigger, since their previous installment of the series. You get the complicated and realistic world-building from Liberty City of GTA4 in the setting of lively and diverse Los Santos, from an old fan favorite GTA San Andreas. 561 different vehicles (including every transport you can operate) and the amount is rising with every update. \nSimultaneous storytelling from three unique perspectives: \nFollow Michael, ex-criminal living his life of leisure away from the past, Franklin, a kid that seeks the better future, and Trevor, the exact past Michael is trying to run away from. \nGTA Online will provide a lot of additional challenge even for the experienced players, coming fresh from the story mode. Now you will have other players around that can help you just as likely as ruin your mission. Every GTA mechanic up to date can be experienced by players through the unique customizable character, and community content paired with the leveling system tends to keep everyone busy and engaged.\n\nEspañol\nRockstar Games se hizo más grande desde su entrega anterior de la serie. Obtienes la construcción del mundo complicada y realista de Liberty City de GTA4 en el escenario de Los Santos, un viejo favorito de los fans, GTA San Andreas. 561 vehículos diferentes (incluidos todos los transportes que puede operar) y la cantidad aumenta con cada actualización.\nNarración simultánea desde tres perspectivas únicas:\nSigue a Michael, ex-criminal que vive su vida de ocio lejos del pasado, Franklin, un niño que busca un futuro mejor, y Trevor, el pasado exacto del que Michael está tratando de huir.\nGTA Online proporcionará muchos desafíos adicionales incluso para los jugadores experimentados, recién llegados del modo historia. Ahora tendrás otros jugadores cerca que pueden ayudarte con la misma probabilidad que arruinar tu misión. Los jugadores pueden experimentar todas las mecánicas de GTA actualizadas a través del personaje personalizable único, y el contenido de la comunidad combinado con el sistema de nivelación tiende a mantener a todos ocupados y comprometidos.",
    "rating": 4.47,
    "ratings_count": 6316,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      }
    ]
  },
  {
    "id": 3328,
    "slug": "the-witcher-3-wild-hunt",
    "name": "The Witcher 3 Wild Hunt",
    "released": "2015-05-18",
    "background_image": "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
    "description": "The third game in a series, it holds nothing back from the player. Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale. Following the source material more accurately, this time Geralt is trying to find the child of the prophecy, Ciri while making a quick coin from various contracts on the side. Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.\n\nCD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third-person action RPG base game they provided 2 massive DLCs with unique questlines and 16 smaller DLCs, containing extra quests and items.\n\nPlayers praise the game for its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction.",
    "rating": 4.66,
    "ratings_count": 6011,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      },
      {
        "id": 5,
        "name": "RPG",
        "slug": "role-playing-games-rpg"
      }
    ]
  },
  {
    "id": 5286,
    "slug": "tomb-raider",
    "name": "Tomb Raider (2013)",
    "released": "2013-03-05",
    "background_image": "https://media.rawg.io/media/games/021/021c4e21a1824d2526f925eff6324653.jpg",
    "description": "A cinematic revival of the series in its action third person form, Tomb Rider follows Lara in her least experience period of life – her youth. Heavily influenced by Naughty Dog’s “Uncharted”, the game is a mix of everything, from stealth and survival to combat and QTE action scenes.\r\nYoung Lara Croft arrives on the Yamatai, lost island near Japan, as the leader of the expedition in search of the Yamatai Kingdom, with a diverse team of specialists. But shipwreck postponed the successful arrival and seemingly forgotten island is heavily populated with hostile inhabitants, cultists of Solarii Brotherhood.\r\nThe game will be graphic at times, especially after failed QTE’s during some of the survival scenes, but overall players will enjoy classic action adventure, reminiscent of the beginning of the series. This game is not a direct sequel or continuation of existing sub-series within the franchise, but a reboot, setting up Tomb Raider to represent modern gaming experience.\r\nThe game has RPG elements and has a world, which you can explore during the story campaign and after the completion. As well as multiplayer mode, where 2 teams (4 scavengers and 4 survivors) are clashing in 3 game modes while using weapons and environments from the single-player campaign.",
    "rating": 4.05,
    "ratings_count": 3649,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      }
    ]
  },
  {
    "id": 12020,
    "slug": "left-4-dead-2",
    "name": "Left 4 Dead 2",
    "released": "2009-11-17",
    "background_image": "https://media.rawg.io/media/games/d58/d588947d4286e7b5e0e12e1bea7d9844.jpg",
    "description": "Cooperative survival continues with a different set of characters. New survivors are making their way through 5 campaigns with an added ability to play through the story of the first game as well, using not only expanded arsenal of 20 ranged and 10 melee weapons but improved AI Director. Your surroundings and weather will change; enemy and item placement will differ from map to map, from difficulty to difficulty. New unique special zombies, placed in the unlucky for the player spot, can end your run.\r\nHigh compatibility with community mods will allow you not only to add user-created maps but player models, enemy models, and even in-game music, which will help any player to create the unique experience on top of solid game mechanics.\r\nCompetitive multiplayer mods from arena survival to a head-on competition with another team of survivors are addictive and, in addition to the campaign, will provide you with hundreds of hours of game content.",
    "rating": 4.09,
    "ratings_count": 3051,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 2,
        "name": "Shooter",
        "slug": "shooter"
      }
    ]
  },
  {
    "id": 4291,
    "slug": "counter-strike-global-offensive",
    "name": "Counter-Strike: Global Offensive",
    "released": "2012-08-21",
    "background_image": "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg",
    "description": "Counter-Strike is a multiplayer phenomenon in its simplicity. No complicated narratives to explain the source of the conflict, no futuristic and alien threats, but counter-terrorists against terrorists. Arena shooter at its core, CS:GO provides you with various methods of disposing enemies and reliant on cooperation within the team. During the round of the classical clash mode, you will gradually receive currency to purchase different equipment. Each player can carry a primary weapon, secondary pistol, knife and a set of grenades, which all can change the battle if wielded by the skilled player. \r\nObjectives are clear and vary from map to map, from game mode to game mode. Stop the terrorists from planting explosives, stop the counter-terrorist from retrieving the hostages, kill everyone who isn’t you and just perform the best with.\r\nCS:GO is one of the major cybersport discipline, which makes playing it more exciting to some players. Aside from purchasing the game, CS:GO is infamous for its loot case system, that requires players to purchase keys, in order to open said cases. Customization items consist of weapon skins, weapon stickers, and sprays that do not affect gameplay and have purely visual value to the player.",
    "rating": 3.56,
    "ratings_count": 3227,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 2,
        "name": "Shooter",
        "slug": "shooter"
      }
    ]
  },
  {
    "id": 5679,
    "slug": "the-elder-scrolls-v-skyrim",
    "name": "The Elder Scrolls V: Skyrim",
    "released": "2011-11-11",
    "background_image": "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg",
    "description": "The fifth game in the series, Skyrim takes us on a journey through the coldest region of Cyrodiil. Once again player can traverse the open world RPG armed with various medieval weapons and magic, to become a hero of Nordic legends –Dovahkiin, the Dragonborn. After mandatory character creation players will have to escape not only imprisonment but a fire-breathing dragon. Something Skyrim hasn’t seen in centuries.\r\nAfter Oblivion, the magic system was reworked, in order to show players more aggressive and direct combat. As a Dragonborn, your character will be able to use the powerful magic of dragon shouts, powered, upgraded and researched with the souls of the dragons that will be randomly encountered by players, while traveling. Hundreds of sidequests will invite players to discover every part of the newly introduced land. Aside from already filled with guilds, Daedra and steampunk Dwemer ruins, Skyrim has additional DLC content that not only brings Solstheim island and vampire conclave but gives players the ability to build their own homes, instead of buying pre-made ones.",
    "rating": 4.42,
     "ratings_count": 4324,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 5,
        "name": "RPG",
        "slug": "role-playing-games-rpg"
      }
    ]
  },
  {
    "id": 4062,
    "slug": "bioshock-infinite",
    "name": "BioShock Infinite",
    "released": "2013-03-26",
    "background_image": "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg",
    "description": "The third game in the series, Bioshock takes the story of the underwater confinement within the lost city of Rapture and takes it in the sky-city of Columbia. Players will follow Booker DeWitt, a private eye with a military past; as he will attempt to wipe his debts with the only skill he’s good at – finding people. Aside from obvious story and style differences, this time Bioshock protagonist has a personality, character, and voice, no longer the protagonist is a silent man, trying to survive.\r\nOpen and bright level design of Columbia shows industrial colonial America in a seemingly endless carnival. But Bioshock is not famous for its visuals, but for its story.  Mystery and creative vision of Irrational Games invite players to uncover the secrets of Columbia’s leader - Zachary Comstock and save Elizabeth, the girl, that’s been locked up in the flying city since her birth.\r\nUnique weapons and mechanics of Vigor will make encounters different, helping players to adjust to the new found mobility and hook shot, making fights fast-paced and imaginative.",
    "rating": 4.39,
    "ratings_count": 3782,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 2,
        "name": "Shooter",
        "slug": "shooter"
      }
    ]
  },
  {
    "id": 28,
    "slug": "red-dead-redemption-2",
    "name": "Red Dead Redemption 2",
    "released": "2018-10-26",
    "background_image": "https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg",
    "description": "America, 1899. The end of the wild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed. \r\n\r\nAfter a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang who raised him.\r\n\r\nFrom the creators of Grand Theft Auto V and Red Dead Redemption, Red Dead Redemption 2 is an epic tale of life in America at the dawn of the modern age.",
    "rating": 4.59,
    "ratings_count": 4510,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      }
    ]
  },
  {
    "id": 3439,
    "slug": "life-is-strange-episode-1-2",
    "name": "Life is Strange",
    "released": "2015-01-29",
    "background_image": "https://media.rawg.io/media/games/562/562553814dd54e001a541e4ee83a591c.jpg",
    "description": "Interactive storytelling and plot-heavy games gained popularity, and “Life is Strange” arrived as teen mystery adventure. The plot will go through the life of Maxine, a teenager in possession of curious power, allowing her to stop and rewind time, in order to manipulate her surroundings. Max, after the reunion with her friend Chloe, is on the path to uncovering the secrets of Arcadia Bay. Players will have to deal with puzzle solving through the fetch quests, in order to change the world around them. \nThe game puts players in situations, where they’re forced to make a moral choice, going through the decision which may have short-term or long-term consequences. Every choice made by the player will trigger the butterfly effect, surrounding the first playthrough of the game with a lot of emotional struggle, thoughtfully crafted by the developers at Dontnod Entertainment. Life is Strange is third person adventure game, where players might seem just as an observer of the stories, unfolding in front of them.",
    "rating": 4.11,
    "ratings_count": 3427,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      }
    ]
  },
  {
    "id": 802,
    "slug": "borderlands-2",
    "name": "Borderlands 2",
    "released": "2012-09-18",
    "background_image": "https://media.rawg.io/media/games/49c/49c3dfa4ce2f6f140cc4825868e858cb.jpg",
    "description": "Sequel to the 4-player cooperative FPS RPG Borderlands, where the new team of Vault Hunters arrives on the infamous planet Pandora in order to get the riches, hidden inside the Vault, and help to free the planet from the Handsome Jack, President of Hyperion. Clear out the endless waves and groups and marauders with various weapon types and character abilities.\r\nUnlike the first game, Borderlands 2 provided DLC not only expanding the world of Pandora with stand-alone story campaigns but adding 2 more characters. Now the main cast consists of Gunzerker Salvador(dual-wields guns at command), Siren Maya (holds and paralyzes the enemy), Commando Axton (summons turrets) and Zer0 the Assasin (invisible sniper ninja). But with the DLC players can try out summoning giant flying robots with Gaige the Mechromancer and Krieg the Psycho. \r\nMost of the game charm and popularity of Borderlands 2 comes from the supporting cast and the personalities of the NPC, making this fast-paced shooter with optional cover stand out.",
    "rating": 4.02,
    "ratings_count": 3025,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 2,
        "name": "Shooter",
        "slug": "shooter"
      },
      {
        "id": 5,
        "name": "RPG",
        "slug": "role-playing-games-rpg"
      }
    ]
  },
  {
    "id": 58175,
    "slug": "god-of-war-2",
    "name": "God of War (2018)",
    "released": "2018-04-20",
    "background_image": "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg",
    "description": "It is a new beginning for Kratos. Living as a man outside the shadow of the gods, he ventures into the brutal Norse wilds with his son Atreus, fighting to fulfill a deeply personal quest. \r\n\r\nHis vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… And teach his son to do the same. This startling reimagining of God of War deconstructs the core elements that defined the series—satisfying combat; breathtaking scale; and a powerful narrative—and fuses them anew. \r\n\r\nKratos is a father again. As mentor and protector to Atreus, a son determined to earn his respect, he is forced to deal with and control the rage that has long defined him while out in a very dangerous world with his son. \r\n\r\nFrom the marble and columns of ornate Olympus to the gritty forests, mountains, and caves of Pre-Viking Norse lore, this is a distinctly new realm with its own pantheon of creatures, monsters, and gods. With an added emphasis on discovery and exploration, the world will draw players in to explore every inch of God of War’s breathtakingly threatening landscape—by far the largest in the franchise. \r\n\r\nWith an over the shoulder free camera that brings the player closer to the action than ever before, fights in God of War mirror the pantheon of Norse creatures Kratos will face: grand, gritty, and grueling. A new main weapon and new abilities retain the defining spirit of God of War while presenting a vision of violent conflict that forges new ground in the genre",
    "rating": 4.59,
    "ratings_count": 4352,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      },
      {
        "id": 5,
        "name": "RPG",
        "slug": "role-playing-games-rpg"
      }
    ]
  },
  {
    "id": 41494,
    "slug": "cyberpunk-2077",
    "name": "Cyberpunk 2077",
    "released": "2020-12-10",
    "background_image": "https://media.rawg.io/media/games/26d/26d4437715bee60138dab4a7c8c59c92.jpg",
    "description": "Cyberpunk 2077 is a science fiction game loosely based on the role-playing game Cyberpunk 2020.\r\n\r\n###Setting\r\nThe game is set in the year 2077 in a fictional futuristic metropolis Night City in California. In the world of the game, there are developed cybernetic augmentations that enhance people's strength, agility, and memory. The city is governed by corporations. Many jobs are taken over by the robots, leaving a lot of people poor and homeless. Night City has a roaring underworld, with black markets, underground surgeons, drug dealers, and street gangs abound.\r\n\r\n###Characters\r\nThe main protagonist is fully customizable, including his or her sex and appearance, and goes by the nickname V. He or she is an underground mercenary who does “dirty business” for the various contractors. An NPC companion named Jackie joins the protagonist early at the game, and various other companions may join the player on certain missions as the plot demands. However, the game has no parties and no companion system.\r\n\r\n###Gameplay\r\nThe player controls V from the first person view, with the third-person view used for cutscenes only. The protagonist can travel across the city on feet or using various vehicles, in a manner some observers compared to GTA series. There are many options for the character customization, including three character classes, and a variety of augmentations V can install to enhance his or her abilities.",
    "rating": 4.11,
    "ratings_count": 2185,
    "esrb_rating": "Mature",
    "genres": [
      {
        "id": 4,
        "name": "Action",
        "slug": "action"
      },
      {
        "id": 3,
        "name": "Adventure",
        "slug": "adventure"
      },
      {
        "id": 5,
        "name": "RPG",
        "slug": "role-playing-games-rpg"
      }
    ]
  }
]
"""
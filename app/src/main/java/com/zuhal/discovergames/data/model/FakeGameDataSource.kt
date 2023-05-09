package com.zuhal.discovergames.data.model

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

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
    "rating": 4.47,
    "ratings_count": 6314,
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
    "name": "The Witcher 3: Wild Hunt",
    "released": "2015-05-18",
    "background_image": "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
    "rating": 4.66,
    "ratings_count": 6008,
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
    "rating": 4.05,
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
    "rating": 4.09,
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
    "rating": 3.56,
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
    "rating": 4.42,
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
    "rating": 4.39,
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
    "rating": 4.59,
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
    "rating": 4.11,
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
    "rating": 4.02,
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
    "rating": 4.59,
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
    "rating": 4.11,
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
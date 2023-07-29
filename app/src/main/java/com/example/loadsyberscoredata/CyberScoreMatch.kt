package com.example.loadsyberscoredata

data class CyberScoreMatch(
    val props: Props
)

data class Author(
    val label: String,
    val value: Int
)

data class BansTeamDire(
    val hero: Hero
)

data class BansTeamRadiant(
    val hero: Hero
)

data class BarracksState(
    val time: Int,
    val value_dire: String,
    val value_radiant: String
)

data class Hero(
    val label: String
)

data class HeroXX(
    val id_steam: String,
    val label: String,
    val name: String
)

data class InitialState(
    val matches_item: MatchesItem,
    val user_country: String
)

data class MatchesItem(
    val bans_team_dire: List<BansTeamDire>,
    val bans_team_radiant: List<BansTeamRadiant>,
    val barracks_state: List<BarracksState>,
    val best_of: Int,
    val game_map_number: Int,
    val game_time: Int,
    val id: Int,
    val networth: List<Networth>,
    val odds: List<Odd>,
    val picks_team_dire: List<PicksTeamDire>,
    val picks_team_radiant: List<PicksTeamRadiant>,
    val score_team_dire: Int,
    val score_team_radiant: Int,
    val team_dire: TeamDire,
    val team_dire_id: Int,
    val team_radiant: TeamRadiant,
    val team_radiant_id: Int,
    val ticks_team_dire: Int,
    val ticks_team_radiant: Int,
    val tournament: Tournament,
    val tournament_stage: String,
    val towers_state: List<TowersState>,
    val video_stream_items_all: List<VideoStreamItemsAll>,
    val winner: Any
)

data class Networth(
    val team: String,
    val time: Int,
    val value: Int
)

data class Odd(
    val info: String,
    val name: String,
    val value: String
)

data class PageProps(
    val initialState: InitialState
)

data class PicksTeamDire(
    val hero: HeroXX,
    val player: Player
)

data class PicksTeamRadiant(
    val hero: HeroXX,
    val player: Player
)

data class Player(
    val game_name: String,
    val label: String,
    val leaderboard_rank: Int
)

data class Props(
    val pageProps: PageProps
)

data class TeamDire(
    val id: Int,
    val name: String,
    val tag: String
)

data class TeamRadiant(
    val id: Int,
    val name: String,
    val tag: String
)

data class Tournament(
    val id: Int,
    val name: String,
    val name_alternative: String,
    val prize: Int,
    val tier: Int
)

data class TowersState(
    val time: Int,
    val value_dire: String,
    val value_radiant: String
)

data class VideoStreamItemsAll(
    val author: Author,
    val language: String,
    val name: String,
    val video: String
)
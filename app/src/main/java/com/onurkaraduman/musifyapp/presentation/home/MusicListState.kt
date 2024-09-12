import com.onurkaraduman.musifyapp.common.Resource
import com.onurkaraduman.musifyapp.domain.model.discover.DiscoverMusicModel
import com.onurkaraduman.musifyapp.domain.model.genre.GenresModel
import com.onurkaraduman.musifyapp.domain.model.popular.PopularMusicsModel

sealed class MusicState {
    data class Discover(val state: GenericMusicState<DiscoverMusicModel>) : MusicState()
    data class Genres(val state: GenericMusicState<GenresModel>) : MusicState()
    data class Popular(val state: GenericMusicState<PopularMusicsModel>) : MusicState()
}

data class GenericMusicState<T>(
    val isLoading: Boolean = false,
    val data: List<T> = emptyList(),
    val error: String = ""
)

data class MusicListState(
    val discoverMusicState: MusicState.Discover = MusicState.Discover(GenericMusicState()),
    val genresState: MusicState.Genres = MusicState.Genres(GenericMusicState()),
    val popularMusicState: MusicState.Popular = MusicState.Popular(GenericMusicState())
)

//
//data class HomeScreenUIState(
//    val isLoading: Boolean = false,
//    val errorTypes: ErrorType? = null,
//    val discoverMusicList: List<DiscoverMusicModel> = emptyList(),
//    val genresMusicList: List<GenresModel> = emptyList(),
//    val popularMusicList: List<PopularMusicsModel> = emptyList()
//)
//sealed class ErrorType{
//   data class  ERROR_DISCOVER(val errorMessage:String):ErrorType()
//   data class  ERROR_GENRES(val errorMessage:String):ErrorType()
//   data class  ERROR_POPULAR(val errorMessage:String):ErrorType()
//}



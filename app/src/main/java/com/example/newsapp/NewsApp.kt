import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.newsapp.ui.theme.NewsAppTheme



data class Noticias(val titulo: String, val imageUrl: String)

@Composable
fun NewsApp(modifier: Modifier = Modifier){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Barra de buscar
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(
                "Buscar"
            ) },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, top = 16.dp),

            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            )
        )

        // Barra de filtro
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                "Noticias"
            )
            Text(
                "Eventos",
                color = Color.Gray
            )
            Text(
                "Clima",
                color = Color.Gray
            )
        }

        Text(
            modifier = Modifier.
            padding(bottom = 20.dp),
            text = "Ultimas Noticias",
            fontSize = 20.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
        val Lista = listOf(
            "El presidente de EE.UU. no muestra signos de arrepentimiento...",
            "Bañarse en la piscina del desierto de Cleopatra",
            "Gigantes tecnológicos",
            "El rover de Marte envía nuevas imágenes"
        )

        // Noticias Barras
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(Lista) { news ->

                Box(
                    modifier = Modifier
                        .size(width = 200.dp, height = 120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF6C63FF))
                        .padding(12.dp)
                ) {
                    Text(
                        text = news,
                        color = Color.White

                    )
                }

            }
        }

        //Noticias cartas con imagenes
        val listaNoticias = listOf(
            Noticias("El presidente de EE.UU. no muestra signos de arrepentimiento...", "https://static01.nyt.com/images/2025/01/17/espanol/17dc-trump-photo-01-cpvw-ES-copy1/17dc-trump-photo-01-cpvw-jumbo.jpg?quality=75&auto=webp"),
            Noticias("Bañarse en la piscina del desierto de Cleopatra", "https://static.wikia.nocookie.net/amor-de-otro-mundo/images/b/b0/Cleopatra.png/revision/latest?cb=20221211124811&path-prefix=es"),
            Noticias("Gigantes tecnológicos", "https://ichef.bbci.co.uk/ace/ws/800/cpsprodpb/9fa5/live/5e7f42c0-20d7-11ee-b2fa-a5b23768df59.jpg.webp"),
            Noticias("El rover de Marte envía nuevas imágenes", "https://josevicentediaz.com/wp-content/uploads/2014/09/matt.jpg")
        )
        Text(
            modifier = Modifier.
            padding(bottom = 3.dp, top = 20.dp),
            text = "Alrededor del mundo"
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(listaNoticias) { noticia ->
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(24.dp))
                ) {

                    AsyncImage(
                        model = noticia.imageUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )


                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White.copy(alpha = 0.8f))
                            .padding(10.dp)
                    ) {
                        Text(
                            text = noticia.titulo,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 3
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsAppPreview(){
    NewsAppTheme {
        NewsApp()
    }
}
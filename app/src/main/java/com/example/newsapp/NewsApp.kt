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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.ui.theme.NewsAppTheme

@Composable
fun NewsApp(){



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




    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsAppPreview(){
    NewsAppTheme {
        NewsApp()
    }
}
package dominando.android.hotel

object MemoryRepositoty : HotelRepository {
    private var nextInt = 1L
    private val hotelList = mutableListOf<Hotel>()
    init {
        save(Hotel(0, "New Beach Hotel", "Av. Boa Viagem", 4.5F))
        save(Hotel(0, "Recife Hotel", "Av. Boa Viagem", 4.0F))
        save(Hotel(0, "Canario Hotel", "Rua Mamanguape", 3.0F))
        save(Hotel(0, "Grand Hotel Dor", "Av. Bernardo", 4.0F))
        save(Hotel(0, "Hotel Cool", "Av. Conselheiro Aguiar", 3.5F))
        save(Hotel(0, "Hotel Infinito", "Rua Ribeiro de Brito", 5.0F))
        save(Hotel(0, "Hotel Tulipa", "Av. Boa Viagem", 4.5F))
    }

    override fun save(hotel: Hotel) {
        if(hotel.id == 0L){
            hotel.id = nextInt++
            hotelList.add(hotel)

        }else{
            val index = hotelList.indexOfFirst { it.id == hotel.id }
            if(index > -1) {
                hotelList[index] = hotel
            } else {
                hotelList.add(hotel)
            }
        }
    }

    override fun remove(vararg hotels: Hotel) {
        hotelList.removeAll(hotels)
    }

    override fun hotelById(id: Long, callback: (Hotel?) -> Unit) {
        callback(hotelList.find{ it.id == id})
    }

    override fun search(term: String, callback: (List<Hotel?>) -> Unit) {
        callback(
            if(term.isEmpty()) hotelList
            else hotelList.filter { it.name.toUpperCase().contains(term.toUpperCase()) }
        )
    }
}
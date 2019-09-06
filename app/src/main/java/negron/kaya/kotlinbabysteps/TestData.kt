package negron.kaya.kotlinbabysteps

class TestData {

    companion object PetData {

        fun getPets() : List<Pet> {

            val pets: MutableList<Pet> = ArrayList()

            var pet = Pet("Koda", 8, Owner("Kaya"))
            pets.add(pet)

            pet = Pet("Bowie", 2, Owner("Ximena"))
            pets.add(pet)

            pet = Pet("Yuki", 4, Owner("Sole"))
            pets.add(pet)

            pet = Pet("Arturo", 10, Owner("Carla"))
            pets.add(pet)


            pet = Pet("Pufi", 18, Owner("Sofia"))
            pets.add(pet)


            pet = Pet("Koda", 8, Owner("Kaya"))
            pets.add(pet)


            pet = Pet("Koda", 8, Owner("Kaya"))
            pets.add(pet)


            pet = Pet("Koda", 8, Owner("Kaya"))
            pets.add(pet)


            pet = Pet("Koda", 8, Owner("Kaya"))
            pets.add(pet)


            pet = Pet("Firulais", 8, null)
            pets.add(pet)

            return pets
        }

    }
}
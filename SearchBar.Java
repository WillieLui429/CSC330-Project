 SearchBar(String query)
    {
        try {
            Int i=Integer.parseInt(query);
            if(pokemon.id.contains(i))
            {
                return pokemon.id.indexOf(i);
            }
        } catch (NumberFormatException)
         {
            if(pokemon.name.contains(query))
            {
                pokemon.name.indexOf(query);
            }
            else(!(pokemon.name.contains(query)))
            {
                System.out.println(query + "was not found");
            }
        }
    }
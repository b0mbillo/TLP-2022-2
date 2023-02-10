import pandas as pd

#1.
letras = ("P","Q","R","W","X","Y","Z")
digitos = ("9","8","7","6","5")
especiales = ("_","#","&","%")
comb = [a+b+c+d+e+f for a in letras for b in letras for c in letras for d in digitos for e in digitos for f in especiales]
print(comb)

#2.
#Importar el dataset
cvs = pd.read_csv("C:\\Users\\Usuario\\Desktop\\VPLs Python\\all_seasons.csv")
df = pd.DataFrame(cvs)
#print(df)

#Imprimir los primeros 5 datos
print(df.head())

#Encontrar la longitud del dataset
print("Tamaño: ", df.size, " Longitud: ",df.shape[0]) #o len(df)

#Imprimir los encabezados
print("Encabezados: ",[i for i in df.columns])

#Eliminar las columnas innecesarias
dfpodado = df[["player_name", "team_abbreviation", "age",
"player_height", "player_weight", "draft_year", "season"]]
print(dfpodado)

#Obtener un sub dataFrame con la última temporada existente
season =dfpodado.iloc[-1]["season"]
#print(season)
filtrado = dfpodado.query("season == @season")
print(filtrado)

#Encontrar el jugador más joven, menos joven y el promedio de edad de la temporada
viejo = filtrado.loc[filtrado["age"] == max(filtrado["age"])]
joven = filtrado.loc[filtrado["age"] == min(filtrado["age"])]
print("Menos joven: \n",viejo)
print("Mas joven: \n",joven)
promedio = round(filtrado["age"].mean())
print("promedio de edad",promedio)

#Encontrar la desviación estándar de las estaturas de la temporada
desv = filtrado["player_height"].std()
print("desviacion estandar estatura: ",desv)

#Generar una columna que permita brindar una calificación a los jugadores basado en: Edad + peso + altura
df['calificacion'] = df.apply(lambda registro: registro.age + registro.player_weight + registro.player_height, axis = 1)
#print(df[["player_weight","player_height","age","calificacion"]]) #para ver la suma
print(df)

#Encontrar los equipos con los mejores puntajes asociados a sus jugadores
equiposCal = df[["team_abbreviation","calificacion"]].sort_values(by="calificacion",ascending=False)
#print(equiposCal)
mEquipos = equiposCal.head(10)
print(mEquipos)
print("Los equipos a los que pertenecen los 10 mejores puntajes: ")
print(mEquipos["team_abbreviation"])
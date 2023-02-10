""" 
El código “12345” debería mostrar el precio $7.500
El código “23456” debería mostrar el precio $12.400
El código “99999” debería mostrar “Error código de barras no encontrado”
Un código vacío debería mostrar “Error: producto no encontrado”
 """

import unittest
from Escanear import Escanear
class testCodigos(unittest.TestCase):
    def test_cod1(self):
        escaneo = Escanear("12345")
        retorno = escaneo.retorno
        self.assertEqual(retorno,7500)

    def test_cod2(self):
        escaneo = Escanear("23456")
        retorno = escaneo.retorno
        self.assertEqual(retorno,12400)

    def test_cod3(self):
        escaneo = Escanear("99999")
        retorno = escaneo.retorno
        self.assertEqual(retorno,"Error código de barras no encontrado")

    def test_vacio(self):
        escaneo = Escanear()
        retorno = escaneo.retorno
        self.assertEqual(retorno,"Error: producto no encontrado")


if __name__=='__main__':
    unittest.main()





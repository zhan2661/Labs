class Random:
    def __init__(self,seed):
        self.seed= seed
        self.nextnum = seed
        
    def next(self,range):
        self.range = range
        self.nextnum = ((7**5)*self.nextnum)%(2**31-1)## the random integers equation. 
        return self.nextnum%self.range


    def choose (self,characters):
        self.characters = characters
        return characters[self.next(len(characters))]## random choose the string from characters
        

   
class Words:
    def __init__(self,seed):
        self.seed = seed
        self.__first = ""
        self.__follow = {}
        self.__random = Random(self.seed)
    def add(self,word):
        self.word = word
        self.__first+= word[0]## add first letter to self.first
        for i in range(0,len(word)-1):## len word - 1
            if word[i] in self.__follow:## check the key's value has in self.follow or not.
                self.__follow[word[i]]= self.__follow[word[i]] + word[i+1] ## yes, keep the value in key and add new one.
            else:
                self.__follow[word[i]]= word[i+1]## no, just add the key and value.
        return None
    def make(self,size):
        self.size = size
        b =""
        a = self.__random.choose(self.__first)## random choose the first letter.
        b+=a
        for i in range(1,size): ## run size-1 times
            if a in self.__follow:## if first letter in the self.follow
             a = self.__random.choose(self.__follow[a])## then "a" equals to following letters.
             b+=a
            else:
                a = self.__random.choose(self.__first)## if can not find the following letters.re-choose the first letter.
                b+=a
        return b
            
def a():
    prez = Words(101) 
    prez.add('Washington') 
    prez.add('Adams') 
    prez.add('Jefferson') 
    prez.add('Madison') 
    prez.add('Monroe') 
    prez.add('Adams') 
    prez.add('Jackson') 
    prez.add('Vanburen') 
    prez.add('Harrison') 
    prez.add('Tyler') 
    prez.add('Polk') 
    prez.add('Taylor') 
    prez.add('Fillmore') 
    prez.add('Pierce') 
    prez.add('Buchanan') 
    prez.add('Lincoln') 
    prez.add('Johnson') 
    prez.add('Grant') 
    prez.add('Hayes') 
    prez.add('Garfield') 
    prez.add('Arthur') 
    prez.add('Cleveland') 
    prez.add('Harrison') 
    prez.add('Cleveland') 
    prez.add('Mckinley') 
    prez.add('Roosevelt') 
    prez.add('Taft') 
    prez.add('Wilson') 
    prez.add('Harding') 
    prez.add('Coolidge') 
    prez.add('Hoover') 
    prez.add('Roosevelt') 
    prez.add('Truman') 
    prez.add('Eisenhower') 
    prez.add('Kennedy') 
    prez.add('Johnson') 
    prez.add('Nixon') 
    prez.add('Ford') 
    prez.add('Carter') 
    prez.add('Reagan') 
    prez.add('Bush') 
    prez.add('Clinton') 
    prez.add('Bush') 
    prez.add('Obama') 
    prez.add('Trump')
    for i in range(10):
        print(prez.make(7))

##answer:
##Grurumo
##Jonsone
##Hansoro
##Cldisoe
##Fovenay
##Fisooos
##Clnnhin
##Taruson
##Tayeylo
##Adgeama     

            
    

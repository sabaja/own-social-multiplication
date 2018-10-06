# own-social-multiplication
# conoscere tutte le variabili di configurazione locali.
git config -l

# Lo strumento essenziale per guardare cos'è successo nel passato è il comando
git log
git log --pretty
git log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen (%cr) %C(bold blue)<%an>%Creset' --abbrev-commit --date=relative

#Inizializzare un repository
git init

#Before push to confirm the changes
git commit -m "Messaggio per la commit"

#Use below before you push anything.
git pull origin master 

#push a un repository
git remote add origin https://github.com/sabaja/ticket-management.git
git push -u origin master

#force
git push -f origin https://github.com/sabaja/jpa-spring-rest

#how to view git index file
git ls-files --stage

#Il comando fetch scarica queste informazioni nel tuo repository locale ma non le unisce automaticamente e non modifica alcun file su cui stai lavorando. Scarica dalla #remote fetch URL configurata.
git fetch https://github.com/sabaja/own-social-multiplication.git

#effettua il merge in locale degli aggiornamenti scaricati da remoto con il comando git fetch.
git merge

#Vedere le modifiche prima di fare pull dal 
git diff master origin/master

#Il comando pull invece fa la fetch e la combina con una merge, quindi tenta di modificare i file locali automaticamente:
git pull https://github.com/sabaja/own-social-multiplication.git

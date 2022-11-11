import matplotlib.pyplot as plt
import datetime
import numpy as np
import pandas as pd
import os

hoje = str(datetime.date.today())

arquivo = "\\Export_toAnalisar_0_" + hoje.replace("-", "_") + ".csv"

print()

banco = pd.read_csv(os.getcwd() + "\\Python\\" + arquivo, sep=";")

qtdArquivos = len(banco[banco.head(0).columns[0]])

qtdArquivos


revisoes = banco.head(0).columns[1]
arquivos = banco.head(0).columns[0]

banco[revisoes].fillna("-1", inplace = True)

banco = banco[banco[revisoes].str.len().lt(4)]

banco[revisoes].value_counts()

labels = banco[revisoes].value_counts().index.tolist()

labels



fig1, ax1 = plt.subplots(figsize=(8,8))

cmap = plt.get_cmap("Set2")
colors = cmap(np.array([1, 2, 3, 4, 5, 6, 7]))

try:
    ax1.pie(banco[revisoes].value_counts(),
        radius=1.3,
        labeldistance=.8,
        startangle=90,
        colors=colors,
        counterclock=False,
        wedgeprops={'edgecolor': 'white'},
        textprops={'fontsize': 7},
        pctdistance=0.8,
        )

    total = 100. *banco[revisoes].value_counts()/banco[revisoes].value_counts().sum()

    labels_filtro = ['{0} - {1:1.2f} %'.format(i,j) for i,j in zip(labels, total)]

    plt.legend(labels_filtro, loc="best", fontsize=8)

    centre_circle = plt.Circle((0,0),0.70,fc='white')
    ax1 = plt.gcf()
    ax1.gca().add_artist(centre_circle)

    plt.tight_layout()

    ax1.savefig(os.getcwd() + "\\Python\\" + "Analise_0_" + hoje.replace("-", "_") + ".png", dpi=350)

except: 
    pass
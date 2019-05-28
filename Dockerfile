FROM almondsh/almond:latest

USER root
RUN apt-get update && apt-get install -y graphviz
USER $NB_UID
RUN jupyter labextension install @jupyterlab/plotly-extension

RUN rm -fr images scala-tour scalameta TransmogrifAI visualization work index.ipynb interactive_computing_article.ipynb plotly_examples.ipynb spark.ipynb tensorflow_scala.ipynb vegas.ipynb

COPY --chown=1000:100 notebooks/ $HOME

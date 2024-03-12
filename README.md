# CubeManiaPhantoms
Плагин Bukkit, позволяющий отключить фантомов, для проекта CubeMania


## Конфигурация
``` yaml
# Белый список миров, в которых необходимо включить плагин. По умолчанию включает все миры
enabledWorlds:
- world
- world_nether
- world_the_end

# Отключить или включить спавн фантомов
allowNaturalSpawn: true

# Применять нижеследующие действия только к фантомам? Неестественный спаун - это с помощью яица призыва.
onlyNerfNatural: true

# Отключить звуки фантомов (пока работает не полностью. Отключены только некоторые звуки фантомов)
muteSound: false

# Отключает ИИ фантомов. Приводит к тому, что они зависают в одной позиции и не двигаются.
disableAI: false

# Модификатор урона фантомов. PhantomDamage * damageModifier = Урон игрока
damageModifier: 1.0

# Здоровье фантома, по умолчанию оно равно 20. Если установить значение 0, они мгновенно умирают.
health: 20.0

# Должны ли все фантомы иметь фиксированный размер?
fixedSize:
  enabled: false
  # Какого размера должны быть фантомы?
  value: 1

# Конфигурация базы данных
# База данных используется для запоминания того, включил или выключил игрок фантомов.
# По умолчанию используется sqlite, где 'name' - это имя файла базы данных. Остальные поля игнорируются.
# Так же, можно поставить на 'mysql', если вы хотите, чтобы плагин подключался к MySQL.
database:
  enabled: false
  type: sqlite
  name: nerfphantoms
  host: localhost
  port: 3306
  username: root
  password: '123456'
```

С версии 1.0.1 вы также можете использовать sqlite. Установите `type` на sqlite и `name` на имя вашего файла. `host` и `port` в этом случае будут игнорироваться.

## Команды
`/cmphantoms reload`: Перезагрузить параметры из файла конфигурации\
`/cmphantoms kill`: Убить всех фантомов в текущем мире.\
`/cmphantoms togglespawn`: Переключение фантомов у себя.\
`/cmphantoms togglespawn <player>`: Переключение фантомов для другого игрока.

## Права
``` yaml
  cmphantoms.*:
    description: Полный доступ к командам плагина
    default: op
    children:
      nerfphantoms.all: true
  cmphantoms.all:
    description: Полный доступ к командам плагина
    children:
      nerfphantoms.reload: true
      nerfphantoms.kill: true
      nerfphantoms.disablespawn.self: true
      nerfphantoms.disablespawn.other: true
  cmphantoms.reload:
    description: Перезагрузка конфигурации плагина
    default: false
  cmphantoms.kill:
    description: Убить всех фантомов в мире
    default: false
  cmphantoms.disablespawn.self:
    description: Отключить фантомов у себя
    default: op
  cmphantoms.disablespawn.others:
    description: Отключить фантомов у другого игрока
    default: op
  cmphantoms.disablespawn.auto:
    description: Автоматически отключить фантомов у игрока
    default: false
```

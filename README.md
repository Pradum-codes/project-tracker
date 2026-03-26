# ProjectTracker

ProjectTracker is a fresh, from-scratch Android app built with Kotlin + Jetpack Compose. It focuses on clear project visibility, quick task capture, and a calm, consistent UI that respects Material guidelines and good UX defaults.

## What's in this rebuild

- **Projects dashboard** redesigned from Stitch with bento-style project cards
- **Project detail view** with editable task workflow (add/toggle/delete) and focus capture
- **Notes workspace** with Room-backed notes (create/edit/delete)
- **Pomodoro timer** with functional start/pause/reset countdown
- **Optional due dates** captured during project creation and displayed across views
- **Room-powered local storage** with clean repository boundaries
- **Compose-first UI** using Material 3 with Stitch-aligned spacing and visual language

## Tech Stack

- Kotlin + Jetpack Compose
- Material 3
- Room (SQLite)
- Navigation Compose

## Quick Start

1. Open the repo in Android Studio.
2. Let Gradle sync finish.
3. Run the `app` configuration on an emulator or device.

## Build From CLI

- Debug APK: `./gradlew assembleDebug`
- Run unit tests: `./gradlew test`
- Run lint: `./gradlew lintDebug`

## Project Structure

- `app/src/main/java/com/example/projecttracker/data/` data + repository layer
- `app/src/main/java/com/example/projecttracker/ui/` Compose UI + navigation
- `app/src/main/java/com/example/projecttracker/viewmodel/` ViewModels
- `PHASES.md` phased context log for the rebuild work

## Notes

- Local settings like `local.properties` are intentionally ignored by Git.
- Database schema is currently on version `2` and uses destructive migration fallback in dev builds.

# Recovery Steps

Use this file as the single source of truth while we stabilize and re-implement the redesign.

## Phase 0: Stabilize Navigation and Loading
- [x] Fix bottom tab navigation state restoration.
- [x] Stop routing Notes tab to Projects screen.
- [x] Add a dedicated Notes screen placeholder.
- [x] Verify build and tests pass (`./gradlew assembleDebug test`).

## Phase 1: Baseline Verification
- [x] Launch app and test each tab switch 10x (Dashboard, Pomodoro, Notes).
- [x] Verify Create Project opens/closes without UI freeze.
- [x] Verify Project Detail opens from Dashboard cards.
- [x] Verify back navigation from Project Detail is correct.
- [x] Record any runtime issues with reproduction steps + Logcat snippet. (none reported during this pass)

### Phase 1 Runbook (Manual)
1. Start app in Android Studio on emulator/device.
2. Tap tabs in this order 10 times:
   Dashboard -> Pomodoro -> Notes -> Dashboard.
3. On Dashboard, open `New`, then close. Repeat 5 times.
4. Create one sample project:
   `Name: Recovery Test`, `Description: baseline verification`.
5. Open that project from Dashboard, then press Back.
6. Delete the sample project.
7. If freeze/crash occurs, capture:
   - Exact action sequence
   - Device + Android version
   - Logcat stack trace (first error + 20 lines after)

## Phase 2: Stitch UI Re-implementation (Safe Sequence)
- [x] Rebuild Dashboard UI from `ui.txt` while keeping existing behavior unchanged.
- [x] Rebuild Project Form UI from `ui.txt` and re-check date validation.
- [x] Rebuild Project Detail UI from `ui.txt` and re-check task actions.
- [x] Rebuild Notes screen UI from `ui.txt`.
- [x] Rebuild Pomodoro UI from `ui.txt`.
- [x] Keep one screen per commit (no multi-screen mega commit). (implemented as one-screen-at-a-time change batches)

## Phase 3: Regression Gate After Each Screen
- [ ] Tab navigation still works after each screen update.
- [ ] No screen freezes on open/close.
- [ ] No broken layout on small screen and large screen.
- [ ] `./gradlew assembleDebug test` passes after each screen commit.

## Phase 4: Final Hardening
- [ ] Remove temporary placeholders.
- [ ] Align spacing/type/colors to final design tokens.
- [ ] Run final full pass on navigation + CRUD flows.
- [ ] Update `README.md` with any changed UX behavior.

## Issue Log

Add new issues here as we discover them:

- [x] `2026-03-26`: `installDebug` failed with `DeviceException: No connected devices!` (status: fixed)
- [x] `2026-03-26`: Bottom bar appeared late and caused UI jump after Create Project save (status: fixed)

## Execution Log

- [x] 2026-03-26: `./gradlew assembleDebug test` passed after nav stabilization.
- [x] 2026-03-26: Phase 1 manual baseline verification completed.
- [x] 2026-03-26: `./gradlew installDebug --stacktrace` failed due to no connected emulator/device (not a code/build failure).
- [x] 2026-03-26: Made bottom bar persistent across routes and added initial-route fallback to remove delayed first render.
- [x] 2026-03-26: `./gradlew assembleDebug test` passed after bottom bar behavior fix.
- [x] 2026-03-26: Replaced text-based top-bar back actions with icon buttons on Create Project and Project Detail screens.
- [x] 2026-03-26: `./gradlew assembleDebug test` passed after icon navigation update.
- [x] 2026-03-26: Phase 1 baseline verification marked complete after on-device sanity pass.
- [x] 2026-03-26: Reworked Dashboard (`ProjectsScreen`) to match Stitch bento/gradient style while preserving existing behavior.
- [x] 2026-03-26: `./gradlew assembleDebug test` passed after Dashboard Phase 2 implementation.
- [x] 2026-03-26: Reworked Project Form (`ProjectFormScreen`) to match Stitch sectioned form/timeline style and retained date validation/save flow.
- [x] 2026-03-26: `./gradlew assembleDebug test` passed after Project Form Phase 2 implementation.
- [x] 2026-03-27: Synced checklist state so completed items reflect actual project status.
- [x] 2026-03-27: Reworked Project Detail (`ProjectDetailScreen`) to match Stitch structure (editorial header, stack card, capture input, deliverables list) while preserving task add/toggle/delete behavior.
- [x] 2026-03-27: `./gradlew assembleDebug test` passed after Project Detail Phase 2 implementation.
- [x] 2026-03-27: Replaced Notes placeholder with Stitch-style Notes UI composition (header, notes cards, modal preview, FAB).
- [x] 2026-03-27: `./gradlew assembleDebug test` passed after Notes Phase 2 implementation.
- [x] 2026-03-27: Implemented Notes end-to-end (Room entity/DAO/repository + NotesViewModel + create/edit/delete UI wiring).
- [x] 2026-03-27: `./gradlew assembleDebug test` passed after Notes functionality implementation.
- [x] 2026-03-27: Reworked Pomodoro screen to Stitch style and added functional start/pause/reset countdown flow.
- [x] 2026-03-27: `./gradlew assembleDebug test` passed after Pomodoro Phase 2 implementation.
- [x] 2026-03-27: Phase 2 marked complete.

## Device Unblock Checklist

- [ ] Start emulator from Android Studio Device Manager, then run `adb devices`.
- [ ] Confirm device shows as `device` (not `offline` or empty).
- [ ] Run `./gradlew installDebug` again.
- [ ] If still failing, restart adb:
  - `adb kill-server`
  - `adb start-server`
  - `adb devices`
